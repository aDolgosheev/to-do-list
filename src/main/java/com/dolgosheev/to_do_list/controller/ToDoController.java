package com.dolgosheev.to_do_list.controller;

import com.dolgosheev.to_do_list.model.ToDoItem;
import com.dolgosheev.to_do_list.repository.ToDoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class ToDoController implements CommandLineRunner {

    private final ToDoItemRepository toDoItemRepository;

    public ToDoController(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    @GetMapping
    public String index(Model model) {
        List<ToDoItem> toDoItemRepositoryAll = toDoItemRepository.findAll();
        model.addAttribute("toDoItemRepositoryAll", toDoItemRepositoryAll);
        model.addAttribute("newToDo", new ToDoItem());

        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ToDoItem toDoItem) {
        toDoItemRepository.save(toDoItem);

        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteToDoItem(@PathVariable("id") Long id) {
        toDoItemRepository.deleteById(id);

        return "redirect:/";
    }

    @PostMapping("/removeAll")
    public String removeAllItems() {
        toDoItemRepository.deleteAll();

        return "redirect:/";
    }

    @PostMapping("/search")
    public String searchToDoItems(@RequestParam("searchTerm") String searchTerm, Model model) {
        List<ToDoItem> allItems = toDoItemRepository.findAll();
        List<ToDoItem> searchResults = new ArrayList<>();

        for (ToDoItem item : allItems) {
            if (item.getTitle().toLowerCase().contains(searchTerm.toLowerCase(Locale.ROOT))) {
                searchResults.add(item);
            }
        }

        model.addAttribute("toDoItemRepositoryAll", searchResults);
        model.addAttribute("newToDo", new ToDoItem());
        model.addAttribute("searchTerm", searchTerm);

        return "index";
    }

    @Override
    public void run(String... args) throws Exception {
        toDoItemRepository.save(new ToDoItem("Item 1"));
        toDoItemRepository.save(new ToDoItem("Item 2"));
    }
}
