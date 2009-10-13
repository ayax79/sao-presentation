import java.sql.DriverManager
import org.hibernate.Session
import org.hibernate.cfg.AnnotationConfiguration
import org.yestech.user.User

if (project.properties['maven.test.skip'] == 'true') return


Class.forName(project.properties['jdbc.driverClassName'])

this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory()
this.call = 0

class SaveDelegate {
  Session session

  def save(o) {
    try {
      session.saveOrUpdate(o)
      session.flush()
    } catch (e) {
      e.printStackTrace()
      throw e;
    }
    return o;
  }

}

def save(o) {


  def con = DriverManager.getConnection(project.properties['jdbc.url'], project.properties['jdbc.username'], project.properties['jdbc.password'])
  def session = this.sessionFactory.openSession(con)
  try {
    println call++

    def result;
    if (o instanceof Closure) {
      result = o.call(new SaveDelegate(session: session))
    }
    else {
      result = new SaveDelegate(session: session).save(o)
    }
    assert result != null
    return result;

  } catch (e) {
    System.err.println e.message
    throw e;
  } finally {
    session.close()
    con.close()
  }
}


try {

	// insert content here
	save new User('Jimmy', 'Page')
	save new User('Issac', 'Brock')



} catch (Exception e) {
  System.err.println e.message
  e.printStackTrace()
  throw e;
} finally {
  if (this.sessionFactory != null) this.sessionFactory.close();
}
