package com.kamil.Simple.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    OwnerService os;

    @RequestMapping(value = "/owner/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Owner> findOwner(@PathVariable String name) {
        return os.getOwner(name);
    }


}
