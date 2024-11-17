package jokardoo.eventmanager.mapper.modelToDto;

import java.util.List;

public interface ModelToDtoMapper<D, M> {

    M toModel(D dto);

    D toDto(M model);

    List<M> toModel(List<D> dtoList);

    List<D> toDto(List<M> modelList);

}
