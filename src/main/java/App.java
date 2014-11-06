import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class App {
    @Autowired
    private JdbcTemplate db;

    @PostConstruct
    public void createTable() {
        db.execute("create table test (id int)");
    }

    @PreDestroy
    public void dropTable() {
        db.execute("drop table test");
    }

    @Transactional
    public void insertOneRecordAndThenThrowException() {
        db.execute("insert into test values(1)");
        throw new RuntimeException("boom!");
    }

    public int countRecords() {
        return db.queryForObject("select count(*) from test", Integer.class);
    }
}
