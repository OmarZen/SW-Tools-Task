// Name: Omar Waleed Zenhom               ID: 20206130
// Name: Muhammed Aladdin Muhammed        ID: 20206068
// Mohamed Ahmed Galal                    ID: 20206060

package Calculation_classes;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Stateless
@Path("/")
public class Calculation_Service {
    
	private static List<Calculation> calculations = new ArrayList<>();

    @POST
    @Path("calc")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response performCalculation(Calculation calculation) {
        try {
            int result;
            switch (calculation.getOperation()) {
                case "+":
                    result = calculation.getNumber1() + calculation.getNumber2();
                    break;
                case "-":
                    result = calculation.getNumber1() - calculation.getNumber2();
                    break;
                case "*":
                    result = calculation.getNumber1() * calculation.getNumber2();
                    break;
                case "/":
                    result = calculation.getNumber1() / calculation.getNumber2();
                    break;
                default:
                    return Response.status(Response.Status.BAD_REQUEST).entity("Invalid operation").build();
            }
            calculations.add(calculation);
            return Response.ok().entity("{\"Result\": " + result + "}").build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
    
    @GET
    @Path("calculations")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Calculation> getCalculations() {
        return calculations;
    }
}
