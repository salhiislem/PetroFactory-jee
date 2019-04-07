package tn.esprit.lavage.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.lavage.entity.Product;

@Stateless
public class ProductService implements ProductServiceRemote {


	@PersistenceContext(unitName="lavage-ejb")
	EntityManager em ;
	@Override
	public void ajouterProduit(Product produit) {
	em.persist(produit);
	em.merge(produit);
		
	}
	@Override
	public List<Product> FindAllProduct() {
		TypedQuery<Product> query= em.createQuery("SELECT c FROM Product c ", Product.class);
		return query.getResultList();
	}
		@Override
		public List getAll() {
		        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
		    }
		@Override
		public void deleteproduct(Product product) {
			em.remove(em.merge(product));
			
		}
		@Override
		public Product FindProductName(String name) {
			return em.find(Product.class, name);
		}
		@Override
		public void UpdateProduct(Product product) {
			em.merge(product);
			
		}
		@Override
		public List<Product> FindProductByName(String name) {
			return em.createQuery("SELECT c FROM Product c WHERE c.ProductName="+name, Product.class).getResultList();
		}
		@Override
		public Product FindProductById(Integer id) {
			return em.find(Product.class, id);
		
		}
		
		public Product findByna(String Name){
			Product utilisateur=null;
			
			try {
				utilisateur=
						em.createQuery
						("SELECT u FROM Product u WHERE u.productName=:p1"
								,Product.class)
				.setParameter("p1",Name).getSingleResult();
			} catch (Exception e) {
			return null;
			}
			return utilisateur;
			
		
		}
		public void updateTrackName(String i, String category,String descrip,float prix,int sto,int id) {
			Product p= em.find(Product.class, id);
			p.setProductName(i);
			p.setCategory(category);
			p.setDescription(descrip);
			p.setPrice(prix);
			p.setStock(sto);
			
			
		}
	}

	

