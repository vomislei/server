package br.edu.utfpr.pb.tcc2.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.edu.utfpr.pb.tcc2.model.Imovel;
import br.edu.utfpr.pb.tcc2.service.ClienteService;
import br.edu.utfpr.pb.tcc2.service.CrudService;
import br.edu.utfpr.pb.tcc2.service.ImovelService;

@RestController
@RequestMapping("imovel")
public class ImovelController extends CrudController<Imovel, Long> {

	@Autowired
	private ImovelService imovelService;

	@Autowired
	private ClienteService clienteService;

	@Override
	protected CrudService<Imovel, Long> getService() {
		return imovelService;
	}

	@GetMapping("/findByCliente")
	public List<Imovel> findByCliente(Long id) {
		return imovelService.findByCliente(clienteService.findOne(id));

	}

	// UPLOAD
	@PostMapping("upload/{id}")
	public void upload(@PathVariable Long id, @RequestParam("imagem") MultipartFile imagem, HttpServletRequest request)
			throws Exception {

		if (imagem != null) {
			saveFile(id, imagem, request);
		}
	}

	private void saveFile(Long id, MultipartFile imagem, HttpServletRequest request) throws Exception {
		File dir = new File(request.getServletContext().getRealPath("/images/"));
		if (!dir.exists()) {
			dir.mkdirs();
		}

		String caminhoAnexo = request.getServletContext().getRealPath("images/");
		String extensao = imagem.getOriginalFilename().substring(imagem.getOriginalFilename().lastIndexOf("."),
				imagem.getOriginalFilename().length());
		String nomeArquivo = id + extensao;
		try {
			FileOutputStream fileOut = new FileOutputStream(new File(caminhoAnexo + nomeArquivo));
			BufferedOutputStream stream = new BufferedOutputStream(fileOut);
			stream.write(imagem.getBytes());
			stream.close();

			Imovel imovel  = getService().findOne(id);
			imovel.setImagem(nomeArquivo);
			getService().save(imovel);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao fazer" + "upload da imagem. " + e.getMessage());
		}
	}

}
