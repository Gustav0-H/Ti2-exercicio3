package src.main.java.app;

import static spark.Spark.*;

import service.ProdutoService;

public class Aplicacao {

    private static ProdutoService produtoService = new ProdutoService();

    public static void main(String[] args) {
        port(5432);

        post("/produto", (request, response) -> {
            return produtoService.add(request, response);
        });

        get("/produto/:id", (request, response) -> {
            return produtoService.get(request, response);
        });

        put("/produto/update/:id", (request, response) -> {
            return produtoService.update(request, response);
        });

        delete("/produto/delete/:id", (request, response) -> {
            return produtoService.remove(request, response);
        });

        get("/produto", (request, response) -> {
            return produtoService.getAll(request, response);
        });

    }
}