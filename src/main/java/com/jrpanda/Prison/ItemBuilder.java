package com.jrpanda.Prison;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    private ItemMeta meta = null;
    private int amount;
    private Material material;
    private String name = null;
    private List<String> lore = new ArrayList<>();

    public ItemBuilder(Material material, int amount){
        this.material = material;
        this.amount = amount;
    }

    public ItemBuilder(Material material){
        this(material, 1);
    }

    public ItemBuilder(ItemStack item){
        this.meta = meta;
        this.material = material;
        this.amount = amount;
    }

    public ItemBuilder setName(String text){
        this.name = text;
        return this;
    }

    public ItemBuilder addLore(String line){
        this.lore.add(Helper.toColor(line));
        return this;
    }

    public ItemStack build(){
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        if(this.meta!= null){
            meta = this.meta;
        }
        if(this.name!= null){
            meta.setDisplayName(Helper.toColor(name));
        }
        if(!lore.isEmpty()){
            meta.setLore(lore);
        }

        item.setItemMeta(meta);
        return item;

    }
}
