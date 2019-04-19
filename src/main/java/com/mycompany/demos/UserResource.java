/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demos;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.mycompany.demos.data.User;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author chaks
 */
@ApplicationScoped
@Path("/")
public class UserResource {

  @Inject
  Bucket bucket;

  @GET
  @Path("/user/{uid}")
  @Produces(MediaType.APPLICATION_JSON)
  public User getUser(@PathParam("uid") String uid) {
    JsonDocument response = bucket.get(uid);

    User user = new User();
    user.setFirstName(response.content().getString("firstName"));
    user.setLastName(response.content().getString("lastName"));
    user.setAge(response.content().getInt("age"));
    user.setUid(response.content().getString("uid"));
    return user;
  }

  @POST
  @Path("/user")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_XML)
  public String putUser(User user) {
    String uniqueID = UUID.randomUUID().toString();
    JsonObject userObj = JsonObject.create()
            .put("firstName", user.getFirstName())
            .put("lastName", user.getLastName())
            .put("age", user.getAge())
            .put("uid", uniqueID);
    JsonDocument userJsonDoc = JsonDocument.create(uniqueID, userObj);
    JsonDocument response = bucket.insert(userJsonDoc);

    return response.id();
  }
}
