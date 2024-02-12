package com.example.repositories;

import com.example.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
//    private final List<Reader> readers;
//
//    public ReaderRepository() {
//        this.readers = new ArrayList<>();
//    }
//
//    @PostConstruct
//    public void generateData() {
//        readers.addAll(List.of(
//                new com.example.model.Reader("Reader1")
//        ));
//    }
//
//    public Reader getReaderById(long id) {
//        return readers.stream().filter(it -> Objects.equals(it.getId(), id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public Reader delreaderById(long id) {
//        Reader reader = getReaderById(id);
//        if (reader != null) {
//            readers.remove(reader);
//        }
//        return reader;
//    }
//
//    public Reader createReader(String name) {
//        Reader reader = new Reader(name);
//        readers.add(reader);
//        return reader;
//    }
//
//    public List<Reader> getAllReader() {
//        List<Reader> copyReader = new ArrayList<>(readers);
//        return copyReader;
//    }
}
