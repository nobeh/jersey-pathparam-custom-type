import java.net.InetAddress;

import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InetAddressSubResource {

  private InetAddress address;

  public InetAddressSubResource(InetAddress address, Object object) {
    this.address = address;
  }

  @GET
  public Response get() {
    return Response.ok(address, MediaType.TEXT_PLAIN).build();
  }

}
