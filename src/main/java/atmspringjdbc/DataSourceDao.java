package atmspringjdbc;

import java.util.Map;

public interface DataSourceDao {
    Map<Integer, Customer> findAll();
}
