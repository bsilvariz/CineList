package com.bsilva.cinelist.controller;

import com.bsilva.cinelist.model.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class CineController {

    private final List<Filme> listaFilmes = new ArrayList<>();
    private Long proximoId = 1L;

    public CineController() {
        // Dados iniciais para teste na tabela
        listaFilmes.add(new Filme(proximoId++, "De Volta para o Futuro", "Ficção Científica", 1985, "Robert Zemeckis", 5));
        listaFilmes.add(new Filme(proximoId++, "O Auto da Compadecida", "Comédia", 2000, "Guel Arraes", 5));
        listaFilmes.add(new Filme(proximoId++, "O Poderoso Chefão", "Drama", 1972, "Francis Ford Coppola", 5));
        listaFilmes.add(new Filme(proximoId++, "Central do Brasil", "Drama", 1998, "Walter Salles", 4));
    }

    // 1. LISTAR (GET /filmes/index)
    @GetMapping("/index")
    public String index(ModelMap model) {
        model.addAttribute("filmes", listaFilmes);
        model.addAttribute("totalFilmes", listaFilmes.size());

        if (!model.containsAttribute("filme")) {
            model.addAttribute("filme", new Filme());
        }

        return "filmes/index";
    }

    // 2. SALVAR OU ATUALIZAR (POST /filmes/save)
    @PostMapping("/save")
    public String save(@ModelAttribute("filme") Filme filme) {
        if (filme.getId() == null) {
            filme.setId(proximoId++);
            listaFilmes.add(filme);
        } else {
            for (int i = 0; i < listaFilmes.size(); i++) {
                if (listaFilmes.get(i).getId().equals(filme.getId())) {
                    listaFilmes.set(i, filme);
                    break;
                }
            }
        }
        return "redirect:/filmes/index";
    }

    // 3. EDITAR (GET /filmes/edit/{id})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap model) {
        Filme filmeEncontrado = listaFilmes.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(new Filme());

        model.addAttribute("filme", filmeEncontrado);
        model.addAttribute("filmes", listaFilmes);
        model.addAttribute("totalFilmes", listaFilmes.size());

        return "filmes/index";
    }

    // 4. EXCLUIR (GET /filmes/delete/{id})
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        listaFilmes.removeIf(f -> f.getId().equals(id));
        return "redirect:/filmes/index";
    }
}
