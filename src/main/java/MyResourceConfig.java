import org.glassfish.jersey.message.MessageProperties;
import org.glassfish.jersey.server.ResourceConfig;

public class MyResourceConfig extends ResourceConfig {

  public MyResourceConfig() {
    property(MessageProperties.LEGACY_WORKERS_ORDERING, Boolean.TRUE);

    registerClasses(Custom1ReaderWriter.class, Custom2ReaderWriter.class,
        InetAddressReaderWriter.class);
    registerInstances(new RootResource(new Object()));

  }

}
