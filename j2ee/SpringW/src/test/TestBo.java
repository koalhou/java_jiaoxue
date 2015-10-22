package test;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TestBo {

	public TestBo() {
		
	}
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
//		this.jdbcTemplate.execute("select * from clw_tqc_gonggao_t");
	}

	public void doSth() {
		// TODO Auto-generated method stub
		int countOfActorsNamedJoe = this.jdbcTemplate.queryForInt("select count(*) from t_actor where first_name = ?");  
		System.out.println("Count of actors : " + countOfActorsNamedJoe);
	}

//	public void setDataSource(DataSource dataSource) {  
//	}  

	
	
	//queryForInt  
//	  int countOfActorsNamedJoe = this.jdbcTemplate.queryForInt("select count(*) from t_actor where first_name = ?");  
	   
	//queryForString   
//	 String lastName = (String)this.jdbcTemplate.queryForObject("select last_name from t_actor where id = ?", new Object[]{1212L}, String.class);   
//	        
//	 // queryForObject  
//	 Actor actor = this.jdbcTemplate.queryForObject(  
//	   "select first_name, last_name from t_actor where id = ?",  
//	   new Object[]{1212L},  
//	   new RowMapper<Actor>() {  
//	   public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {  
//	   Actor actor = new Actor();  
//	   actor.setFirstName(rs.getString("first_name"));  
//	   actor.setLastName(rs.getString("last_name"));  
//	   return actor;  
//	   }  
//	   });  
//	     
//	   
//	 //queryForObjectList    
//	 List<Actor> actors = this.jdbcTemplate.query(  
//	  "select first_name, last_name from t_actor",  
//	  new RowMapper<Actor>() {  
//	  public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {  
//	  Actor actor = new Actor();  
//	  actor.setFirstName(rs.getString("first_name"));  
//	  actor.setLastName(rs.getString("last_name"));  
//	  return actor;  
//	  }  
//	 });  
//	   
//	 //another queryForObjectList  
//	 public List<Actor> findAllActors() {
//	  return this.jdbcTemplate.query( "select first_name, last_name from t_actor", new ActorMapper());  
//	  }  
//	 private static final class ActorMapper implements RowMapper<Actor> {  
//	  public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {  
//	   Actor actor = new Actor();  
//	   actor.setFirstName(rs.getString("first_name"));  
//	   actor.setLastName(rs.getString("last_name"));  
//	   return actor;  
//	  }  
//	 }  
//	   
//	 //update and delete  
//	 this.jdbcTemplate.update(  
//	  "update t_actor set = ? where id = ?",  
//	  "Banjo", 5276L);  
//	 )  

}
