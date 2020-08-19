package com.pgk.journal.controllers;


import com.pgk.journal.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Controller
public class JournalController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(path = "/")
    public String allEntry(Model model) {

        LdapUserDetailsImpl ldapDetails = (LdapUserDetailsImpl) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        String dn = ldapDetails.getDn();
        int beginIndex = dn.indexOf("cn=") + 4;
        int endIndex = dn.indexOf(",");
        String username = dn.substring(beginIndex, endIndex);

        model.addAttribute("username",username);


        return "journal";
    }

    @RequestMapping(path = "/saveEntry")
    public @ResponseBody String saveEntry (@RequestParam Long idEntry,
                                           @RequestParam String fio,
                                          @RequestParam String dateOfAbsence,
                                          @RequestParam String startTime,
                                          @RequestParam String endTime,
                                          @RequestParam String placeCause){
        entryService.saveEntry( idEntry, fio, dateOfAbsence, startTime, endTime, placeCause);
        return null;
    }

    @RequestMapping(path = "/deleteEntry")
    public @ResponseBody String deleteEntry (@RequestParam Long idEntry){
        entryService.deleteEntryById(idEntry);
        return null;
    }

    @RequestMapping(path = "/loadEntry")
    public @ResponseBody String loadEntry (@RequestParam String searchText,
                                           @RequestParam String startDate,
                                           @RequestParam String endDate,
                                           @RequestParam Integer page,
                                           @RequestParam Boolean sortAsc){
        return entryService.getJsonEntryList(searchText,startDate,endDate, page==null?0:page,sortAsc);
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        model.addAttribute("error", error!=null);
        model.addAttribute("logout", logout!=null);
        return "login";
    }
}