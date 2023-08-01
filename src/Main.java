import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File diploma = new File("diploma.csv");

        int index = 0;
        ArrayList<DiplomaData> diplomaData = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<String> diplomaLanjutan = new ArrayList<>();
        ArrayList<String> kursusPengkhususan = new ArrayList<>();

        if(diploma.exists()){
            System.out.println("File exists");

            if (diploma.canRead()){
                System.out.println("File is readable");
            }else {
                System.out.println("File is unreadable");
            }

            try(Scanner reader = new Scanner(diploma)) {
                while (reader.hasNext()){
                    String line = reader.nextLine();

                    if (index > 0) {
                        String[] items = line.split(",");

                        int total = 0;
                        int max = 0;
                        int num;

                        for (int i = 1; i < items.length; i++){
                            if (Character.isDigit(items[i].charAt(0))){
                                num = Integer.parseInt(items[i]);
                                if (num > max){
                                    max = num;
                                }
                                total += num;
                            }
                        }

                        int min = max;

                        for (int i = 1; i < items.length; i++){
                            if (Character.isDigit(items[i].charAt(0))){
                                num = Integer.parseInt(items[i]);
                                if (num < min){
                                    min = num;
                                }
                            }
                        }

                        DiplomaData data = new DiplomaData(items[1], items[2], total, max, min);

                        diplomaData.add(data);

                        System.out.print(index + ". ");
                        System.out.println(data);
                        System.out.println();

                        if (items[1].equals(" Diploma Lanjutan")){
                            diplomaLanjutan.add(items[2]);
                        }
                        if (items[1].equals("Kursus Pengkhususan")){
                            kursusPengkhususan.add(items[2]);
                        }
                    }
                    index++;
                }

                System.out.println("Total: "+diplomaLanjutan.size()+"\nDiploma Lanjutan names: ");
                for (String name:diplomaLanjutan){
                    System.out.println(name);
                }

                System.out.println();

                System.out.println("Total: "+kursusPengkhususan.size()+"\nKursus Pengkhususan names: ");
                for (String name:kursusPengkhususan){
                    System.out.println(name);
                }

                for (DiplomaData row: diplomaData){
                    if(!(categories.contains(row.getCategory()))){
                        categories.add(row.getCategory());
                    }
                }

                for (String category: categories){
                    try(PrintWriter writer = new PrintWriter(new File(category+".txt"))){
                        for (DiplomaData row: diplomaData){
                            if (category.equals(row.getCategory())){
                                writer.println(row);
                            }
                        }
                    }catch (FileNotFoundException exception){
                        System.out.println(exception.getMessage());
                    }
                }

            }catch (FileNotFoundException exception){
                System.out.println(exception.getMessage());
            }
        }else {
            System.out.println("File does not exists");
        }

    }
}