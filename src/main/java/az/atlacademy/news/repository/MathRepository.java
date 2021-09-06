package az.atlacademy.news.repository;

import aj.org.objectweb.asm.Type;
import az.atlacademy.news.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.Types;
import java.util.Map;

@RequiredArgsConstructor
@Repository
@CrossOrigin
public class MathRepository {

    private final EntityManager entityManager;


    public Integer getCount(int number, int step) {
        Integer result =
                (Integer) entityManager
                        .createNativeQuery("select  get_count(:number,:step)")
                        .setParameter("number", number)
                        .setParameter("step", step)

                        .getSingleResult();
        return result;

    }

    public Author authors(int id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("fn_authors");
        query.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_name", String.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("p_surname", String.class, ParameterMode.OUT);
        query.setParameter("p_id", id);
        boolean queryResult = query.execute();
        String name = String.valueOf(query.getOutputParameterValue("p_name"));
        String surname = String.valueOf(query.getOutputParameterValue("p_surname"));

        Author a = new
                Author();
        a.setName(name);
        a.setSurname(surname);
        return a;
        // return (Integer) out.get("get_count");

    }

    private final JdbcTemplate jdbcTemplate;


    public Author getCountJdbc(int id) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withFunctionName("fn_authors")
                .declareParameters(new SqlParameter("p_id", Type.INT),
                        new SqlOutParameter("p_name", Types.VARCHAR),
                        new SqlOutParameter("p_surname", Types.VARCHAR)
                );

        MapSqlParameterSource in = new MapSqlParameterSource(
                "p_id", id
        );

        Map<String, Object> out = jdbcCall.execute(in);
        System.out.println((String) out.get("p_name"));
        System.out.println((String) out.get("p_surname"));
        Author a = new
                Author();
        a.setName((String) out.get("p_name"));
        a.setSurname((String) out.get("p_surname"));
        return a;
        // return (Integer) out.get("get_count");

    }

}
