import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class Custom1Resource {

  private Custom1 name;

  public Custom1Resource(Custom1 name) {
    this.name = name;
  }

  @GET
  public Response get() {
    return Response.ok(name, MediaType.TEXT_PLAIN).build();
  }

}
