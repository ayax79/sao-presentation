package org.yestech;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;

/**
 * @author A.J. Wright
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/*")
@Ignore
public class BaseIntegrationTest {

    @Resource
    protected SessionFactory sessionFactory;
    protected Session session;

    @Before
    public void setupSession() {
        session = sessionFactory.openSession();
        TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
        customSetUp();
    }

    /**
     * Called in {@link #setupSession()} after initial state is configured
     */
    protected void customSetUp() {
    }

    @After
    public void destroySession() {
        customTeardown();
        SessionHolder sessionHolder =
                (SessionHolder) TransactionSynchronizationManager.unbindResource(sessionFactory);
        sessionHolder.clear();
        session.flush();
        SessionFactoryUtils.closeSession(session);
    }

    /**
     * Called in {@link #destroySession()} before session is flushed and closed.
     */
    protected void customTeardown() {
    }
}
