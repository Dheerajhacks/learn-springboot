package com.telusko.SpringJDBCDemo.repo;

import com.telusko.SpringJDBCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlienRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien){
        String str = "insert into alien (id, name, tech) values (?, ?, ?)";
        int rows = template.update(str, alien.getId(), alien.getName(), alien.getTech());

        System.out.println("Rows affected : " + rows);
    }
    public List<Alien> findAll(){
        String sql = "select * from alien";

        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));
                return a;
            }
        }; //we need to create RowMapper object to map the result set to our Alien object, we can use lambda expression to create RowMapper object in a more concise way
        // or we can just create a class which implements RowMapper interface and override the mapRow() method to map the result set to our Alien object,
        // and then we can use that class to create RowMapper object and pass it to the query() method
        // or use this method which is called BeanPropertyRowMapper which is provided by Spring to map the result set to our Alien object,
        // we just need to pass the class type of our Alien object to the constructor of BeanPropertyRowMapper
        // and it will automatically map the result set to our Alien object based on the column names and field names of our Alien class, but we need to make sure that
        // the column names in our database table are same as the field names in our Alien class, otherwise it will not work and we will get null values in our Alien object
        List<Alien> list = template.query(sql,mapper );
        return list;
    }
}
