package net.benfro.lab.chronmap;

import com.google.common.collect.Sets;
import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;
import shaded.org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Set;

public class MapBuilder {

   public final ChronicleMap<CharSequence, FileData> theFileData;

   public MapBuilder() {
      ChronicleMapBuilder<CharSequence, FileData> cityPostalCodesMapBuilder =
              ChronicleMapBuilder.of(CharSequence.class, FileData.class)
                      .name("file-data-map")
                      .averageKey("2278a55ce683c3db420154cd602ea9a9")
                      .averageValueSize(25)
                      .entries(50_000);
      theFileData = cityPostalCodesMapBuilder.create();
   }

   public String md5Content(String path, String... more) {
      return md5Content(Paths.get(path, more));
   }

   public String md5Content(Path path) {
      try {
         try (InputStream is = Files.newInputStream(path)) {
            return DigestUtils.md5Hex(is);
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
      return null;
   }

   public void walk(Path start) throws IOException {
      Set<String> set = Sets.newHashSet();

      Files.walkFileTree(start, new SimpleFileVisitor<Path>() {

         @Override
         public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return super.preVisitDirectory(dir, attrs);
         }

         @Override
         public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            //Files.delete(file);
            String md5 = md5Content(file);
            //System.out.println("Size: " + Files.size(file) + ", MD5: " + md5);
            boolean add = set.add(md5);
            if(!add)
               System.out.println("Doublette! " + file.toAbsolutePath());
            return FileVisitResult.CONTINUE;
         }

         @Override
         public FileVisitResult postVisitDirectory(Path dir, IOException e) {
            if (e == null) {
               //Files.delete(dir);
               return FileVisitResult.CONTINUE;
            } else {
               // directory iteration failed
               //throw e;
            }
            return FileVisitResult.CONTINUE;
         }
      });
   }

}
