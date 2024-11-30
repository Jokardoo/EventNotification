package jokardoo.eventmanager.mapper.entityToModel;

import java.util.List;

public interface ModelEntityMapper<M, E> {

    M toModel(E entity);

    E toEntity(M model);

    List<M> toModel(List<E> entityList);

    List<E> toEntity(List<M> modelList);

}
