package org.fero.siliconlove;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.fero.siliconlove.config.SiliconLoveConfig;
import org.fero.siliconlove.constant.SiliconLoveConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entrance for silicon love server.
 *
 * @author Wei Guo
 * @since  2/1/2016
 */
public class SiliconLoveApplication extends Application<SiliconLoveConfig> {

    private static final Logger logger = LoggerFactory.getLogger(SiliconLoveApplication.class);

    public static void main(String[] args) throws Exception {
        new SiliconLoveApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<SiliconLoveConfig> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<SiliconLoveConfig>() {
            @Override
            public DataSourceFactory getDataSourceFactory(SiliconLoveConfig configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public String getName() {
        return SiliconLoveConstant.APP_NAME;
    }

    @Override
    public void run(SiliconLoveConfig configuration, Environment environment) throws Exception {
        logger.info("Register resources...");
        // TODO: Register all resources.
    }
}
