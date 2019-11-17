//Jacob Gaylord
//jigaylord16@ole.augie.edu
//SortPhoneBook.java
//Description: Sorts a file of phone entries.
//Input:       "phone.txt" contains phone entries in the following format:
//             Name1 (a String like "John Johnson")
//             Phone1 (a String like "605-222-2222")
//             Name2
//             Phone2
//             ...
//             NameN
//             PhoneN
//Output:      "phoneSorted.txt" contains entries from "phone.txt" sorted in
//             ascending order based on names.
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class SortPhoneBook
{
  public static void main(String[] args) throws FileNotFoundException
  {
    PhoneBook p = new PhoneBook();
    p.load("phone.txt");
    p.sort();
    p.write("phoneSorted.txt");
  }
}
class PhoneBook
{
  private Vector<String> names;
  private Vector<String> phones;
  //Post:        The PhoneBook object constructed.
  public PhoneBook()
  {
    System.out.println("Phone book constructed");
  }
  //Description: Load the phone entries from a file into the PhoneBook object.
  //Input:       A file with filename s which contains phone entries in the
  //             following format:
  //             Name1 (a String like "John Johnson")
  //             Phone1 (a String like "605-222-2222")
  //             Name2
  //             Phone2
  //             ...
  //             NameN
  //             PhoneN
  //Post:        The names from s loaded in this PhoneBook's names Vector, the
  //             the phones from d loaded in this PhoneBook's phones Vector, so
  //             that the 2 Vectors are parallel.
  public void load(String s) throws FileNotFoundException
  {
    names =new Vector<String>();
    phones =new Vector<String>();
    Scanner input = new Scanner(new File(s));
    while(input.hasNext())
    {
      names.add(input.nextLine());
      phones.add(input.nextLine());
    }
    System.out.println("Phone book loaded from file "+s);
    input.close();
  }
  //Description: Sorts the PhoneBook object based on names.
  //Post:        The names vector sorted in ascending order. The names and
  //             phones Vectors remain parallel.
  public void sort()
  {
    for(int i = 0 ; i < names.size()-1 ; ++i)
    {
      if(names.get(i).compareToIgnoreCase(names.get(i+1)) > 0)
      {
        Collections.swap(names, i, i+1);
        Collections.swap(phones, i, i+1);
      }
      else continue;
    }
    System.out.println("Phone book sorted");
  }
  //Description: Write the phones entries in the PhoneBook object to a file.
  //Pre:         s is the filename of the data file to be written.
  //Output:      The phones entries in the PhoneBook object written to the file
  //             with filename s in the following format:
  //             Name1 (a String like "John Johnson")
  //             Phone1 (a String like "605-222-2222")
  //             Name2
  //             Phone2
  //             ...
  //             NameN
  //             PhoneN
  public void write(String s) throws FileNotFoundException
  {
    PrintWriter output = new PrintWriter(s);
    Iterator<String> namesIter= names.iterator();
    Iterator<String> phonesIter= phones.iterator();
    while(namesIter.hasNext() && phonesIter.hasNext())
    {
      output.println(namesIter.next());
      output.println(phonesIter.next());
    }
    System.out.println("Phone book written to file "+s);
    output.close();
  }
}
