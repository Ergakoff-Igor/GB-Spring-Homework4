package ru.ergakov.gb.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ergakov.gb.model.Act;

import java.util.List;

@Repository
public class ActRepository {


    private final JdbcTemplate jdbc;

    public ActRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Act> findAll() {
        String sql = "SELECT * FROM actTable";
        return jdbc.query(sql, newActRowMapper());
    }

    public Act save(Act act) {
        String sql = "INSERT INTO actTable (reportingPeriod,projectSection, price, status) VALUES ( ?, ?, ?, ?)";
        jdbc.update(sql, act.getReportingPeriod(), act.getProjectSection(), act.getPrice(), act.getStatus());
        return act;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM actTable WHERE id=?";
        jdbc.update(sql, id);
    }

    public Act getOne(int id) {
        String sql = "SELECT * FROM actTable WHERE id=?";
        return jdbc.queryForObject(sql, newActRowMapper(), id);
    }

    public Act updateUser(Act act) {
        String sql = "UPDATE actTable SET reportingPeriod=?, projectSection=?, price=?, status=? WHERE id=?";
        jdbc.update(sql, act.getReportingPeriod(), act.getProjectSection(), act.getPrice(), act.getStatus(), act.getId());
        return act;
    }

    /**
     * Метод создания словаря Актов КС-2
     *
     * @return Словарь пользователей
     */
    private RowMapper<Act> newActRowMapper() {
        return (r, i) -> {
            Act rowObject = new Act();
            rowObject.setId(r.getInt("id"));
            rowObject.setReportingPeriod(r.getString("reportingPeriod"));
            rowObject.setProjectSection(r.getString("projectSection"));
            rowObject.setPrice(r.getDouble("price"));
            rowObject.setStatus(r.getString("status"));
            return rowObject;
        };
    }
}
