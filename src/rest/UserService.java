package rest;

import dto.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UserService {
    static Map<Integer, User> users = new HashMap<>();
    //Insert some dummy data
    static {
        users.put(1, new User(1,"Torben Test", "TT", "Svend", "000", "1234567890"));
        users.put(2, new User(2,"Tim Test", "TT", "Mester", "123", "1234567690"));
        users.put(3, new User(3,"Tina Test", "TT", "Arbejdsmand ", "1234", "1234563890"));
    }




    @GET
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }


    @GET
    @Path("{id}")
    public User getUser(@PathParam("id") int id) {
        return users.get(id);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN) // hvorfor
    public Response addUserJson(User user) throws InvalidIdException {
        if (users.putIfAbsent(user.getId(), user) == null)
            return Response.ok("Det gik godt").build();
        else {
            //3. custom exception
            throw new InvalidIdException("ID " + user.getId() + " er allerede i brug!!");

            //2. Throw WebApplicationException

//        	Response response1 = Response
//        			.status(Status.BAD_REQUEST)
//        			.entity("Id " + ingredient.getId() + " er i brug")
//        			.build();
//
//    		throw new WebApplicationException(response1); //fra jersy
//
            //1. Return response

//        	ResponseBuilder builder = Response.status(Status.BAD_REQUEST);
//        	builder.entity("Id " + ingredient.getId() + " er i brug");
//        	Response response = builder.build();
//        	return response;

//        	Response response = Response
//        			.status(Status.BAD_REQUEST)
//        			.entity("Id " + ingredient.getId() + " er i brug")
//        			.build();
//
//        	return response;




        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteIngredient(@PathParam("id") int id) {
        User existing = users.get(id);
        if (existing != null) {
            users.remove(id);
            return Response.ok("Slettet").build();
        } else {
            return Response.status(Status.BAD_REQUEST).entity("Den findes ikke").build();
        }
    }
}
