package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        while(true){
            System.out.println("");
            System.out.println("");

            System.out.println("1-Просмотр файлов по заданному пути");
            System.out.println("2-Создание файла");
            System.out.println("3-Удаление файла");
            System.out.println("4-Просмотр файла");
            System.out.println("5-Запись в файл");
            System.out.println("6-Переместить файл");

            Scanner in = new Scanner(System.in);
            System.out.print("Выберите пункт: ");
            int num = in.nextInt();
            if(num == 1){
                System.out.println("Введите путь:");
                ViewContent();
            }
            if(num == 2){
                System.out.println("Введите путь для создания: ");
                CreateFile();
            }
            if(num == 3){
                System.out.println("Введите полный путь до файла, который нужно удалить: ");
                DeleteFile();
            }
            if(num == 4){
                System.out.println("Введите полный путь до файла, который нужно прочитать: ");
                ViewFile();
            }
            if(num == 5){
                System.out.println("Введите полный путь до файла, в который нужно записать строки: ");
                WriteFile();
            }
            if(num == 6){
                System.out.println("");
            }

        }
    }
   /*1*/ public static void ViewContent(){
        Scanner sc = new Scanner(System.in);
        String put = sc.nextLine();
        String[] pathnames;

        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        File f = new File(put);

        // Populates the array with names of files and directories
        pathnames = f.list();

        // For each pathname in the pathnames array
        assert pathnames != null;
        for (String pathname : pathnames) {
            // Print the names of files and directories
            System.out.println(pathname);

        }
    }

    /*2*/public static void CreateFile() throws IOException {
        Scanner cr = new Scanner(System.in);
        String create = cr.nextLine();

        String path = create;
        // Use relative path for Unix systems
        File f = new File(path);

        f.getParentFile().mkdirs();
        f.createNewFile();

        if(f.exists()){
            System.out.println(create + "Файл создан");
        }else System.out.println("Файл" + create + "не был создан");

    }

    /*3*/public static void DeleteFile(){
        Scanner dl = new Scanner(System.in);
        String delete = dl.nextLine();

        File file = new File(delete);
        if(file.delete()){
            System.out.println(delete + " файл удален");
        }else System.out.println("Файла" + delete + "не обнаружено");
    }
    /*4*/public static void ViewFile(){
        Scanner VF = new Scanner(System.in);
        String view = VF.nextLine();

        Path path = Paths.get(view);

        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(System.out::println);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*5*/public static void WriteFile(){
        Scanner PathToFile = new Scanner(System.in);
        String ptf = PathToFile.nextLine();

        System.out.println("Введите то, что хотите записать в " + ptf + ": ");

        Scanner WF = new Scanner(System.in);
        String write = WF.nextLine();


        try(FileWriter writer = new FileWriter(ptf, false))
        {

            // запись всей строки
            String text = write;
            writer.write(text);

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
    /*6*/


}
