package org.wisdom.jdbc.driver.derby;

import org.junit.Test;
import org.osgi.service.jdbc.DataSourceFactory;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.XADataSource;
import java.sql.Driver;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Check the behavior of the Derby service.
 */
public class DerbyServiceTest {

    private DataSourceFactory svc = new DerbyService();

    @Test
    public void testNewJdbcDriver() throws Exception {
        Driver driver = svc.createDriver(null);
        assertThat(driver).isNotNull();
    }

    @Test
    public void testNewDataSource() throws Exception {
        DataSource source = svc.createDataSource(null);
        assertThat(source).isNotNull();
    }
}