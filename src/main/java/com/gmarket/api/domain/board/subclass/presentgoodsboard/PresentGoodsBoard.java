package com.gmarket.api.domain.board.subclass.presentgoodsboard;

import com.gmarket.api.domain.board.Board;
import com.gmarket.api.domain.board.dto.subclass.PresentGoodsBoardDto;
import com.gmarket.api.domain.board.subclass.presentgoodsboard.enums.PresentGoodsCategory;
import com.gmarket.api.domain.board.subclass.presentgoodsboard.enums.PresentGoodsStatus;
import lombok.Getter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
public class PresentGoodsBoard extends Board {

    private PresentGoodsCategory presentGoodsCategory;

    private PresentGoodsStatus presentGoodsStatus;

    private LocalDateTime raffleClosedAt;

    public PresentGoodsBoard dtoToPresentGoodsBoard(PresentGoodsBoardDto presentGoodsBoardDto){
        super.dtoToEntity(presentGoodsBoardDto);
        this.presentGoodsCategory = presentGoodsBoardDto.getPresentGoodsCategory();
        this.presentGoodsStatus = presentGoodsBoardDto.getPresentGoodsStatus();
        this.raffleClosedAt = presentGoodsBoardDto.getRaffleClosedAt();
        return this;
    }
}
