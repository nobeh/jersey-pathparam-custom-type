import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class Custom2Resource {

  private Custom2 name;

  public Custom2Resource(Custom2 name) {
    this.name = name;
  }

  @GET
  public Response get() {
    return Response.ok(name, MediaType.TEXT_PLAIN).build();
  }

}
