package com.global.book.base;


import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>,ID extends Number > {

    private BaseRepository<T,ID> baseRepository;
    
    public BaseService(BaseRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public T findById(ID id){
        return baseRepository.findById(id).orElseThrow();
    }
    public T getOne(ID id){
        return baseRepository.getReferenceById(id);
    }
    public List<T> findAll(){
        return baseRepository.findAll();
    }
    public T insert(T entity){
        if(entity.getId() != null){
            throw new RuntimeException();
        }
        return baseRepository.save(entity);
    }
    public T update(T entity){
        return baseRepository.save(entity);
    }
    public void deleteById(ID id){
        baseRepository.deleteById(id);
    }
    public List<T> insertAll(List<T> entity){
        return baseRepository.saveAll(entity);
    }


}
