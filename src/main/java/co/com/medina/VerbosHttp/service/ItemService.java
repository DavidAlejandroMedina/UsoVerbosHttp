package co.com.medina.VerbosHttp.service;

import co.com.medina.VerbosHttp.model.GroceryItem;
import co.com.medina.VerbosHttp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    private List<GroceryItem> groceryItems;

    //Esta variable indica si setGroceryItems() ya ha sido iniciada, si no ha sido iniciada entonces se asignan los datos a la lista groceryItems, de lo contrario no hace nada
    boolean started=false;
    public void setGroceryItems(){
        if (!this.started){
            this.groceryItems = new ArrayList<>();
            groceryItems.add(new GroceryItem("Whole", "Whole Wheat Biscuit", 5, "snacks"));
            groceryItems.add(new GroceryItem("Dried", "Dried Whole Red Chilli", 2, "spices"));
            groceryItems.add(new GroceryItem("Pearl", "Healthy Pearl Millet", 1, "millets"));
            groceryItems.add(new GroceryItem("Cheese", "Bonny Cheese Crackers Plain", 6, "snacks"));
            this.started=true;
        }
    }

    public String getAll(){
        setGroceryItems();
        List<GroceryItem> groceryItems = itemRepository.findAll();
        return "---ITEMS EXISTENTES---\n" + groceryItems.toString();
    }

    public String insert(GroceryItem groceryItem){
        setGroceryItems();
        groceryItems.add(new GroceryItem(groceryItem.getId(), groceryItem.getName(), groceryItem.getQuantity(), groceryItem.getCategory()));
        for (GroceryItem groceryItem1 : groceryItems) {
            itemRepository.save(groceryItem1);
        }
        return "---ITEM INSERTADO---\n" + groceryItem.toString();
    }

    public String update(GroceryItem groceryItem){
        setGroceryItems();
        GroceryItem existingItem = itemRepository.findById(groceryItem.getId()).orElse(null);
        if (existingItem != null) {
            existingItem.setName(groceryItem.getName());
            existingItem.setQuantity(groceryItem.getQuantity());
            existingItem.setCategory(groceryItem.getCategory());
            itemRepository.save(existingItem);
            return "---ITEM ACTUALIZADO---\n" + existingItem.toString();
        }
        else {
            return "---ITEM NO ENCONTRADO---";
        }
    }

    public String delete(String id) {
        setGroceryItems();
        GroceryItem existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            itemRepository.deleteById(id);
            return "---ITEM ELIMINADO---";
        }
        else {
            return "---ITEM NO ENCONTRADO---";
        }
    }

    public String updateData(String id, GroceryItem groceryItem){
        setGroceryItems();
        GroceryItem existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem != null){
            if (groceryItem.getName() != null){
                existingItem.setName(groceryItem.getName());
            }
            if (groceryItem.getCategory() != null){
                existingItem.setCategory(groceryItem.getCategory());
            }
            itemRepository.save(existingItem);
            return "---ITEM ACTUALIZADO---\n" + existingItem.toString();
        }
        else {
            return "---ITEM NO ENCONTRADO---";
        }
    }

    public String optionsUpdate(){
        return "OPTIONS: It insert a new grosery item, if the grosery item doesn't exist, it will create automatically";
    }
}