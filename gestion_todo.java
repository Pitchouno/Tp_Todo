package tp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Todo {
    private Long id;
    private String description;
    private Boolean termine;

    // Constructeur
    public Todo(Long id, String description) {
        this.id = id;
        this.description = description;
        this.termine = false; // Par défaut, la tâche n'est pas terminée
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isTermine() {
        return termine;
    }

    // Marquer la tâche comme terminée
    public void terminer() {
        this.termine = true;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Description: " + description + " | Statut: " + (termine ? "Terminé" : "En cours");
    }
}

public class gestion_todo {
    private List<Todo> todos;
    private Long currentId;

    // Constructeur
    public gestion_todo() {
        this.todos = new ArrayList<>();
        this.currentId = 1L; // ID commence à 1
    }

    // Méthode pour ajouter une nouvelle tâche
    public void ajouterTodo(String description) {
        Todo newTodo = new Todo(currentId, description);
        todos.add(newTodo);
        System.out.println("Tâche ajoutée avec succès : " + newTodo);
        currentId++;
    }

    // Méthode pour terminer une tâche par ID
    public void terminerTodo(Long id) {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                todo.terminer();
                System.out.println("Tâche terminée avec succès : " + todo);
                return;
            }
        }
        System.out.println("Aucune tâche trouvée avec l'ID : " + id);
    }

    // Méthode pour lister toutes les tâches
    public void listerTodos() {
        if (todos.isEmpty()) {
            System.out.println("Aucune tâche disponible.");
        } else {
            System.out.println("Liste des tâches :");
            for (Todo todo : todos) {
                System.out.println(todo);
            }
        }
    }

    // Main
    public static void main(String[] args) {
        gestion_todo app = new gestion_todo();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Application de Gestion de Tâches (Todo) ===");

        while (running) {
            System.out.println("\nChoisissez une option :");
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Terminer une tâche");
            System.out.println("3. Lister les tâches");
            System.out.println("4. Quitter");

            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    System.out.print("Entrez la description de la tâche : ");
                    String description = scanner.nextLine();
                    app.ajouterTodo(description);
                    break;
                case 2:
                    System.out.print("Entrez l'ID de la tâche à terminer : ");
                    Long id = scanner.nextLong();
                    app.terminerTodo(id);
                    break;
                case 3:
                    app.listerTodos();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }
}

