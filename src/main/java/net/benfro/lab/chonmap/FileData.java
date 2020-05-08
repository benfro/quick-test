package net.benfro.lab.chonmap;

public interface FileData {
   String getPath();

   void setPath(String path);

   String getName();

   void setName(String name);

   int getSizeInBytes();

   void setSizeInBytes(int size);
}
