package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    
    private RecoveryRoomService recoveryRoomService;

    @Autowired
    public RecoveryRoomController(RecoveryRoomService service) {
        this.recoveryRoomService = service;
    }

    @GetMapping(value = "/create")
    public ModelAndView getCreateRoomForm() {
        ModelAndView mdv = new ModelAndView("recoveryroom/createOrUpdateRecoveryRoomForm");
        RecoveryRoom recoveryRoom = new RecoveryRoom();
        mdv.addObject("recoveryRoom", recoveryRoom);
        return mdv;
    }

    @PostMapping(value = "/create")
    public ModelAndView createRoom(@Valid RecoveryRoom recoveryRoom, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("recoveryroom/createOrUpdateRecoveryRoomForm");
        } else {
            try {
                recoveryRoomService.save(recoveryRoom);
            } catch(DuplicatedRoomNameException e) {
                return new ModelAndView("recoveryroom/createOrUpdateRecoveryRoomForm");
            }
            ModelAndView mdv = new ModelAndView("welcome");
            return mdv;
        }
    }
    
}
