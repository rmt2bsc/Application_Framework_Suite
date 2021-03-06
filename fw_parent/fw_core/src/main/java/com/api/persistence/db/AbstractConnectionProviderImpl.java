package com.api.persistence.db;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.RMT2Base;
import com.SystemException;
import com.api.ConnectionProvider;
import com.api.config.ConfigConstants;
import com.api.persistence.DatabaseException;
import com.api.util.RMT2File;
import com.api.util.RMT2String;

/**
 * An abstract class providing common functionality for the interface
 * <i>ConnectionProvider</i>.
 * <p>
 * It basically sets up and creates a connection provider.
 * 
 * @author Roy Terrell
 * 
 */
public abstract class AbstractConnectionProviderImpl extends RMT2Base implements
        ConnectionProvider {

    private static Logger logger = Logger
            .getLogger(AbstractConnectionProviderImpl.class);

    /**
     * This is the name of the key that is found in
     * <i>DB-ORM-Config.properites</i> that points to a specific JDBC Resource.
     * <p>
     * This variable can represent a JDBC resource in a variety of ways. For
     * example, it could be the name of JNDI Daatasource, a LDAP Distinguish
     * Name, the full package of a .properties file, or etc.
     */
    protected static final String RESOURCE_KEY_NAME = "DbResourceName";

    private ResourceBundle config;

    private String contextName;

    /**
     * Default constructor
     */
    public AbstractConnectionProviderImpl() {
        super();
    }

    /**
     * Loads the DB ORM connection configuration properteis file as a
     * ResourceBundle
     * 
     * @throws DatabaseException
     * @throws SystemException
     */
    public void init() throws DatabaseException, SystemException {
        logger.info(AbstractConnectionProviderImpl.class.getName()
                + " is initialized");
    }

    /**
     * Obtains the Datasource resource name which associates the physical
     * database connection to the database connection API implementation.
     * 
     * @return the datasource name
     * @throws DatabaseException
     *             Problem loading DB-ORM-Config, DB-ORM-Config cannot be found,
     *             or <i>environment</i> variable is not set in application
     *             configuration.
     */
    protected String getEnvDbResourceName() {
        // Identify either the general purpose or application specific
        // DB-ORM-Config file.
        String ormConfigFile = null;
        if (contextName == null) {
            ormConfigFile = DatabaseConnectionConstants.CONNECTION_CONFIG;
        }
        else {
            ormConfigFile = RMT2String.replace(
                    DatabaseConnectionConstants.API_CONNECTION_CONFIG,
                    contextName,
                    DatabaseConnectionConstants.API_CONNECTION_PLACEHOLDER);
        }

        // Load DB-ORM-Config file
        try {
            this.config = RMT2File.loadAppConfigProperties(ormConfigFile);
        } catch (Exception e) {
            this.msg = "Error loading DB-ORM-Config file: " + ormConfigFile;
            logger.fatal(this.msg);
            throw new DatabaseException(this.msg, e);
        }

        // Get the datasource resouce name based on platform environment
        String env = System.getProperty(ConfigConstants.PROPNAME_ENV);
        if (env == null) {
            this.msg = "Error obtaining DB ORM ResourceName Key.  Unable to determine the environment of application (Test, Production, or Development)";
            logger.fatal(this.msg);
            throw new DatabaseException(this.msg);
        }
        String key = env.toLowerCase() + "." + RESOURCE_KEY_NAME;
        logger.info("The selected DB ORM Resource Name Key is, " + key);
        String resourceName = this.config.getString(key);
        return resourceName;
    }

    /**
     * Returns the ResourceBundle instance containing ORM related configuration
     * properties
     * 
     * @return the config
     */
    public ResourceBundle getConfig() {
        return config;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.api.ConnectionProvider#setContextName(java.lang.String)
     */
    @Override
    public void setContextName(String ctxName) {
        this.contextName = ctxName;

    }

    /**
     * @return the contextName
     */
    public String getContextName() {
        return contextName;
    }
}

