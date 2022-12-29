package deep_clone_serialization;

import java.io.*;

/**
 * Створити клас Bird.
 * Створити 3 поля (static, final та transient), методи, конструктор.
 * Клонувати об'єкт, використовуючи глибоке клонування через серіалізацію
 **/

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird(3);
        Bird.name = "Crow";

        ByteArrayOutputStream byteOutput = null;
        ByteArrayInputStream byteInput = null;

        ObjectOutputStream output = null;
        ObjectInputStream input = null;

        try {
            byteOutput = new ByteArrayOutputStream();
            output = new ObjectOutputStream(byteOutput);
            output.writeObject(bird);

            byteInput = new ByteArrayInputStream(byteOutput.toByteArray());
            input = new ObjectInputStream(byteInput);

            Bird cloneBird = (Bird) input.readObject();
            System.out.println("Original bird " + bird);        // Original bird Bird{ name=Crow, head=1, weight=3}
            System.out.println("Cloned bird " + cloneBird);     // Cloned bird Bird{ name=Crow, head=1, weight=0} - weight is transient
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (byteOutput != null) {
                try {
                    byteOutput.flush();
                    byteOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteInput != null) {
                try {
                    byteInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (output != null) {
                try {
                    output.flush();
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
