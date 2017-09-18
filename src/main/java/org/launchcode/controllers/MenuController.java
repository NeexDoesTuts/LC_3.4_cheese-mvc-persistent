package org.launchcode.controllers;

@Controller
@RequestMapping("menu")
public class MenuController {
}

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CheeseDao cheeseDao;

    @Autowired
    MenuDao menuDao;

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("menus", menuDao.findAll());
        model.addAttribute("title", "Categories");
        return "menu/index";
    }

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Menu());
        model.addAttribute("title", "Add Menu");
        return "menu/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Menu menu, Errors errors) {

        // check for errors as always
        if (errors.hasErrors()) {
            return "menu/add";
        } // implicit else

        menuDao.save(menu);
        return "redirect:/menu/view/" + menu.getId();
    }

}