package tn.esprit.rh.achat.services;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import static org.mockito.Mockito.when;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OperateurServiceTest {
    @Autowired
    private OperateurServiceImpl op;
    @MockBean
    private OperateurRepository operateurRepository;

    @Test
    public void shouldAddOp() {
        Operateur operaterFixture = new Operateur(123L, null,null,null,null);
        when(operateurRepository.save(operaterFixture)).thenReturn(operaterFixture);
        Assertions.assertEquals(operaterFixture, op.addOperateur(operaterFixture));
    }
}