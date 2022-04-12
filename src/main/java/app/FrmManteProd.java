package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Proveedor;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;

	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox cboCategorias;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private int idcategoria, idproveedor, numeroRegistro;
	private JComboBox cboProveedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String codigo = txtCódigo.getText().trim();
				String descripcion = txtDescripcion.getText().trim();
				String categoria = (String) cboCategorias.getSelectedItem();
				String stock = txtStock.getText().trim();
				String precio = txtPrecio.getText().trim();

				if (codigo.equals("")) {
					mensaje("El codigo esta vacío");
				} else if (descripcion.equals("")) {
					mensaje("La Descripción esta vacía");

				} else if (cboCategorias.getSelectedItem().equals("[Seleccionar]")) {
					mensaje("Eliga una Categoria");
				} else if (cboProveedor.getSelectedItem().equals("[Seleccionar]")) {
					mensaje("Eliga un Proveedor");
				} else if (categoria.equals("")) {
					mensaje("La Categoria esta vacía");

				} else if (stock.equals("")) {
					mensaje("El Stock esta vacío");

				} else if (precio.equals("")) {
					mensaje("El Precio esta vacío");

				} else {

					registrar();

				}

			}
		});
		btnNewButton.setBounds(393, 72, 112, 32);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 495, 163);
		contentPane.add(scrollPane);

		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);

		JButton btnListado = 	new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<Producto> listado = listado();
				
					txtSalida.append("==============================================================\n");
				listado.forEach(producto -> {
					txtSalida.append("Registro N° " + ++numeroRegistro + "\n");
					txtSalida.append("==============================================================\n");
					txtSalida.append("Id de Producto          : " + producto.getIdProducto() + "\n");
					txtSalida.append("Descripción de Producto : " + producto.getDescripcion() + "\n");
					txtSalida.append("Stock de Producto       : " + producto.getStock() + "\n");
					txtSalida.append("Precio de Producto      : " + producto.getPrecio() + "\n");
					txtSalida.append("IDCategoria de Producto : " + producto.getIdCategoria() + "\n");
					txtSalida.append("Descripción de Categoria: " + producto.getCategoria().getDescripcion() + "\n");
					txtSalida.append("Estado de Producto      : " + producto.getEstado() + "\n");
					txtSalida.append("IDProveedor de Producto : " + producto.getProveedor().getIdprovedor() + "\n");
					txtSalida.append("Nombre de Producto      : " + producto.getProveedor().getNombre() + "\n");
					txtSalida.append("==============================================================\n");
				});
			}
		});
		btnListado.setBounds(393, 115, 112, 35);
		contentPane.add(btnListado);

		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 144, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Id. Producto : ");
		lblCodigo.setBounds(10, 11, 102, 14);
		contentPane.add(lblCodigo);

		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 144, 22);
		contentPane.add(cboCategorias);

		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 71, 102, 14);
		contentPane.add(lblCategora);

		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 42, 102, 14);
		contentPane.add(lblNomProducto);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 137, 102, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 137, 144, 20);
		contentPane.add(txtStock);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 168, 102, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 168, 144, 20);
		contentPane.add(txtPrecio);

		cboProveedor = new JComboBox();
		cboProveedor.setBounds(122, 104, 144, 22);
		contentPane.add(cboProveedor);

		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(10, 105, 102, 14);
		contentPane.add(lblProveedor);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codigo = txtCódigo.getText().trim();
				String descripcion = txtDescripcion.getText().trim();
				String categoria = (String) cboCategorias.getSelectedItem();
				String proveedor = (String) cboProveedor.getSelectedItem();
				String stock = txtStock.getText().trim();
				String precio = txtPrecio.getText().trim();

				Producto producto = new Producto();
				producto.setIdProducto(codigo);
				producto.setDescripcion(descripcion);
				producto.setStock(Integer.parseInt(stock));
				producto.setPrecio(Double.parseDouble(precio));

				idcategoria = obtenerIdCombo(new Categoria(), categoria);
				idproveedor = obtenerIdCombo(new Proveedor(), proveedor);

				producto.setIdCategoria(idcategoria);
				producto.setIdProveedor(idproveedor);

				// actualizamos
				actualizar(producto);
				System.out.println(producto.toString());

			}
		});
		btnActualizar.setBounds(276, 72, 112, 32);
		contentPane.add(btnActualizar);

		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codigo = txtCódigo.getText().trim();
				Producto obj = seleccionar(codigo);

				// pasamos los valores a los textField
				txtCódigo.setText(obj.getIdProducto());
				txtDescripcion.setText(obj.getDescripcion());
				txtStock.setText(String.valueOf(obj.getStock()));
				txtPrecio.setText(String.valueOf(obj.getPrecio()));
				cboCategorias.setSelectedItem(obj.getCategoria().getDescripcion());
				cboProveedor.setSelectedItem(obj.getProveedor().getNombre());
				
			
				txtCódigo.disable();
				
				
			}
		});
		btnSeleccionar.setBounds(276, 115, 112, 35);
		contentPane.add(btnSeleccionar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = txtCódigo.getText().trim();
				eliminar(codigo);
			}
		});
		btnEliminar.setBounds(393, 157, 112, 31);
		contentPane.add(btnEliminar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				
			}
		});
		btnLimpiar.setBounds(276, 157, 112, 31);
		contentPane.add(btnLimpiar);

		llenaComboCategoria();
		llenaComboProveedor();
	}

	<t> int obtenerIdCombo(t Clase, String ItemComboBox) {

		int resultado = 0;
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		if (Clase instanceof Categoria) {

			TypedQuery<Categoria> consulta = em.createQuery("select x from Categoria x", Categoria.class);
			List<Categoria> lista = consulta.getResultList();

			for (Categoria obj : lista) {
				if (ItemComboBox.equals(obj.getDescripcion())) {
					resultado = obj.getIdcategoria();

				}
			}
		}

		if (Clase instanceof Proveedor) {

			TypedQuery<Proveedor> consultaProveedor = em.createQuery("select x from Proveedor x", Proveedor.class);
			List<Proveedor> listaProveedores = consultaProveedor.getResultList();

			for (Proveedor obj : listaProveedores) {
				if (ItemComboBox.equals(obj.getNombre())) {
					resultado = obj.getIdprovedor();
				}
			}
		}
		return resultado;

	}

	void limpiar() {
		txtCódigo.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
		txtCódigo.requestFocus();
		txtSalida.setText("");
		cboCategorias.setSelectedIndex(0);
		cboProveedor.setSelectedIndex(0);
		
	}

	void llenaComboCategoria() {
		// Fabrica de de acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// Manejador de Identidad
		EntityManager em = fabrica.createEntityManager();

		// Acciones
		// select * from usuarios....
		TypedQuery<Categoria> consulta = em.createQuery("select x from Categoria x", Categoria.class);

		List<Categoria> listaCategorias = consulta.getResultList();

		cboCategorias.addItem("[Seleccionar]");
		for (Categoria obj : listaCategorias) {
			System.out.println(obj.toString());
			cboCategorias.addItem(obj.getDescripcion());
		}
		// cerrar manejador
		em.close();
	}

	void llenaComboProveedor() {
		// Fabrica de de acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// Manejador de Identidad
		EntityManager em = fabrica.createEntityManager();

		// Acciones
		// select * from usuarios....
		TypedQuery<Proveedor> consulta = em.createQuery("select x from Proveedor x", Proveedor.class);

		List<Proveedor> listaProveedores = consulta.getResultList();

		cboProveedor.addItem("[Seleccionar]");
		for (Proveedor obj : listaProveedores) {
			System.out.println(obj.toString());
			cboProveedor.addItem(obj.getNombre());
		}
		// cerrar manejador
		em.close();
	}

	List<Producto> listado() {
		// Fabrica de de acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// Manejador de Identidad
		EntityManager em = fabrica.createEntityManager();

		// Acciones
		// select * from usuarios....
		TypedQuery<Producto> consulta = em.createQuery("select x from Producto x", Producto.class);

		List<Producto> listaProductos = consulta.getResultList();
		for (Producto obj : listaProductos) {
			System.out.println(obj.toString());
		}
		// cerrar manejador
		em.close();

		return listaProductos;
	}

	void registrar() {

		String codigo = txtCódigo.getText().trim();
		String descripcion = txtDescripcion.getText().trim();
		String categoria = (String) cboCategorias.getSelectedItem();
		String proveedor = (String) cboProveedor.getSelectedItem();
		int stock = Integer.parseInt(txtStock.getText().trim());
		double precio = Double.parseDouble(txtPrecio.getText().trim());

		// registrar un nuevo usuario

	
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		
		EntityManager em = fabrica.createEntityManager();


		em.getTransaction().begin();

		idcategoria = obtenerIdCombo(new Categoria(), categoria);
		idproveedor = obtenerIdCombo(new Proveedor(), proveedor);

		// Acciones
		Producto obj = new Producto();
		obj.setIdProducto(codigo);
		obj.setDescripcion(descripcion);
		obj.setIdCategoria(idcategoria);
		obj.setStock(stock);
		obj.setPrecio(precio);
		obj.setIdProveedor(idproveedor);

		if (obj != null) {
			em.persist(obj);
			limpiar();
			mensaje("Se Ingresó un Registro");
			em.getTransaction().commit();
		} else {
			mensaje("El producto es nulo");
			em.getTransaction().rollback();
		}


		// cerrar manejador
		em.close();
	}

	void actualizar(Producto obj) {


		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		
		EntityManager em = fabrica.createEntityManager();

		// empezar los procesos....> create,delete,update,select
		em.getTransaction().begin();

		// Acciones
		// update....
		Producto producto = new Producto();
		producto.setIdProducto(obj.getIdProducto());
		producto.setDescripcion(obj.getDescripcion());
		producto.setStock(obj.getStock());
		producto.setPrecio(obj.getPrecio());
		producto.setIdCategoria(obj.getIdCategoria());
		producto.setEstado(obj.getEstado());
		producto.setIdProveedor(obj.getIdProveedor());

		if (producto != null) {

			em.merge(producto);
			mensaje("Se Actualizo el Registro");
			limpiar();
			em.getTransaction().commit();
		} else {
			em.getTransaction().rollback();
		}

		// cerrar manejador
		em.close();
	}

	void eliminar(String id) {
		// Fabrica de de acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		em.getTransaction().begin();

		Producto obj = em.find(Producto.class, id);
		if (obj != null) {
			System.out.println(obj.toString());
			em.remove(obj);
			mensaje("Se eliminó correctamente");
			limpiar();
			em.getTransaction().commit();
		} else {
			mensaje("El codigo no existe,sorry");
			em.getTransaction().rollback();
		}

		// cerrar manejador
		em.close();
	}

	Producto seleccionar(String id) {

		// Fabrica de de acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// Manejador de Identidad
		EntityManager em = fabrica.createEntityManager();

		// empezar los procesos....> create,delete,update,select

		// Acciones

		Producto obj = em.find(Producto.class, id);

		if (obj != null) {
			System.out.println(obj.toString());
		} else {
			System.out.println("El codigo no existe,sorry");
		}

		em.close();

		return obj;
	}

	public void mensaje(String ms) {
		JOptionPane.showInternalMessageDialog(null, ms);
	}
}
