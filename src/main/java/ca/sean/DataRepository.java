package ca.sean;

import java.util.Map;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class DataRepository {

    @Autowired 
    JdbcTemplate jdbcTemplate;

    public int getNextID(){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall( jdbcTemplate ).withProcedureName( "getNextID" );
        SqlParameterSource in = new MapSqlParameterSource().addValue("inValue", "aService");

        Map<String, Object> out = jdbcCall.execute(in);

        return (int)out.get("result");
    }
}