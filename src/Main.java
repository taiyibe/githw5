import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean is_runnig = true;
        Scanner scanner = new Scanner(System.in);
        List<String> shopList = new ArrayList<>();
        while (is_runnig) {
            System.out.println("1. Добавить");
            System.out.println("2. Показать");
            System.out.println("3. Удалить");
            System.out.println("4. Найти");
            System.out.println("5. Выйти");
            System.out.println("Выберите операцию:");
            String inp = scanner.nextLine();
            Integer opNum;
            try {
                opNum = Integer.parseInt(inp);
            } catch (Exception e) {
                System.out.println("Введён некоректный номер операции");
                continue;
            }
            switch (opNum) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String prod = scanner.nextLine();
                    shopList.add(prod);
                    System.out.printf("Итого покупок: %d.\n\n", shopList.size());
                    break;
                case 2:
                    if (shopList.size() > 0) {
                        System.out.println("Список покупок:");
                        for (int i = 0; i < shopList.size(); i++) {
                            System.out.printf("%d. %s\n", i + 1, shopList.get(i));
                        }
                        System.out.println();
                    } else {
                        System.out.println("Список покупок пуст.\n");
                    }
                    break;
                case 3:
                    if (shopList.size() > 0) {
                        System.out.println("Список покупок:");
                        for (int i = 0; i < shopList.size(); i++) {
                            System.out.printf("%d. %s\n", i + 1, shopList.get(i));
                        }
                        System.out.println("\nКакую покупку хотите удалить? (Введите номер или название)");
                        inp = scanner.nextLine();
                        try {
                            int num = Integer.parseInt(inp) - 1;
                            if (num < 0 || num >= shopList.size()) {
                                System.out.println("Введён некоректный номер покупки.\n");
                            } else {
                                System.out.printf("Покупка \"%s\" удалена, список покупок", shopList.get(num));
                                shopList.remove(num);
                                if (shopList.size() > 0) {
                                    System.out.println(":");
                                    for (int i = 0; i < shopList.size(); i++) {
                                        System.out.printf("%d. %s\n", i + 1, shopList.get(i));
                                    }
                                    System.out.println();
                                } else {
                                    System.out.print(" пуст.\n\n");
                                }
                            }
                        } catch (Exception e) {
                            if (shopList.remove(inp)) {
                                System.out.printf("Покупка \"%s\" удалена, список покупок", inp);
                                if (shopList.size() > 0) {
                                    System.out.println(":");
                                    for (int i = 0; i < shopList.size(); i++) {
                                        System.out.printf("%d. %s\n", i + 1, shopList.get(i));
                                    }
                                    System.out.println();
                                } else {
                                    System.out.print(" пуст.\n\n");
                                }
                            } else {
                                System.out.printf("Покупка \"%s\" не найдена.\n\n", inp);
                            }
                        }
                    } else {
                        System.out.println("Список покупок пуст.\n");
                    }
                    break;
                case 4:
                    if (shopList.size() > 0) {
                        System.out.println("Введите текст для поиска:\n");
                        List<Integer> rs = new ArrayList<>();
                        String query = scanner.nextLine().toLowerCase();
                        for (int i = 0; i < shopList.size(); i++) {
                            if (shopList.get(i).toLowerCase().contains(query)) {
                                rs.add(i);
                            }
                        }
                        if (rs.size() > 0) {
                            System.out.println("Найдено:");
                            for (int i = 0; i < rs.size(); i++) {
                                System.out.printf("%d. %s\n", rs.get(i) + 1, shopList.get(rs.get(i)));
                            }
                            System.out.println();
                        } else {
                            System.out.println("Ничего не найдено.\n");
                        }
                    } else {
                        System.out.println("Список покупок пуст.\n");
                    }
                    break;
                case 5:
                    is_runnig = false;
                    break;
                default:
                    System.out.println("Введён некоректный номер операции.\n\n");
                    break;
            }
        }
        scanner.close();
    }
}