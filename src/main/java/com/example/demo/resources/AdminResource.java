package com.example.demo.resources;

import com.example.demo.models.Admin;
import com.example.demo.repositoris.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/admin")
public class AdminResource {

    @Autowired
    private AdminRepository adminRepository;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdmin(){
        List<Admin> list = new ArrayList<>();
        Iterable<Admin> adminList = adminRepository.findAll();
        adminList.forEach(list::add);
        return Response.ok(list).build();
    }
}
