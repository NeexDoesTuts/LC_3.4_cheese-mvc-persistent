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
}