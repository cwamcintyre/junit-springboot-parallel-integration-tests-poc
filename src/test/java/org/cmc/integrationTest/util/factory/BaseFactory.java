package org.cmc.integrationTest.util.factory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class BaseFactory<
        TEntity,
        TBuilder,
        TId,
        TRepository extends JpaRepository<TEntity, TId>> {

    private TRepository dataRepository;
    private final Function<TEntity, TBuilder> toBuilder;
    private final Function<TBuilder, TEntity> buildFromBuilder;

    public BaseFactory(
            TRepository repository,
            Function<TEntity, TBuilder> toBuilder,
            Function<TBuilder, TEntity> buildFromBuilder) {
        this.dataRepository = repository;
        this.toBuilder = toBuilder;
        this.buildFromBuilder = buildFromBuilder;
    }

    public abstract TEntity create();

    public TEntity create(Consumer<TBuilder> customiser) {
        TEntity entity = create();
        TBuilder builder = toBuilder.apply(entity);
        customiser.accept(builder);
        return buildFromBuilder.apply(builder);
    }

    public List<TEntity> createMultiple(int count, Consumer<TBuilder> customiser) {
        List<TEntity> entities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            entities.add(create(customiser));
        }
        return entities;
    }

    public List<TEntity> createMultiple(int count) {
        List<TEntity> entities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            entities.add(create());
        }
        return entities;
    }

    private void persist(TEntity entity) {
        dataRepository.save(entity);
    }

    private void persistAll(List<TEntity> entities) {
        dataRepository.saveAll(entities);
    }

    public TEntity createAndPersist() {
        TEntity customer = create();
        persist(customer);
        return customer;
    }

    public TEntity createAndPersist(Consumer<TBuilder> customiser) {
        TEntity customer = create(customiser);
        persist(customer);
        return customer;
    }

    public List<TEntity> createAndPersistMultiple(int count) {
        List<TEntity> entities = createMultiple(count);
        persistAll(entities);
        return entities;
    }

    public List<TEntity> createAndPersistMultiple(int count, Consumer<TBuilder> customiser) {
        List<TEntity> entities = createMultiple(count, customiser);
        persistAll(entities);
        return entities;
    }
}