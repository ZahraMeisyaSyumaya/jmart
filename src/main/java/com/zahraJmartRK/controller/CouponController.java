package com.zahraJmartRK.controller;


import com.zahraJmartRK.Algorithm;
import com.zahraJmartRK.Coupon;
import com.zahraJmartRK.dbjson.JsonAutowired;
import com.zahraJmartRK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon>
{
    @JsonAutowired(value = Coupon.class,filepath = "C:/Users/Zahra/repo baru/jmart/src/main/Coupon.json")
    public static JsonTable<Coupon> couponTable;

    @Override
    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }

    @GetMapping("/{id}/canApply")
    @ResponseBody
    boolean canApply
            (
                    @RequestParam int id,
                    @RequestParam double price,
                    @RequestParam double discount
            )
    {
        for(Coupon each : couponTable)
        {
            if (each.id == id) {
                return each.canApply(price, discount);
            }
        }
        return false;
    }

    @GetMapping("/{id}/isUsed")
    @ResponseBody
    boolean isUsed
            (
                    @RequestParam int id
            )
    {
        for(Coupon each : couponTable)
        {
            if (each.id == id) {
                return each.isUsed();
            }
        }
        return false;
    }

    @GetMapping("/getAvailable")
    @ResponseBody
    List<Coupon> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(couponTable, page, pageSize, pred-> !pred.isUsed());
    }
}
