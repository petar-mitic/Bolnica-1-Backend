package raf.bolnica1.laboratory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import raf.bolnica1.laboratory.domain.lab.Prescription;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    @Query("SELECT p FROM Prescription p WHERE p.id=:id")
    Prescription findPrescriptionById(@Param("id")Long id);

    @Query("SELECT p FROM Prescription p WHERE p.lbp = :lbp AND p.doctorLbz = :doctorLbz")
    List<Prescription> findPrescriptionsByLbpAndDoctorLbz(@Param("lbp") String lbp, @Param("doctorLbz") String doctorLbz);

    @Query("SELECT p FROM Prescription p WHERE p.lbp = :lbp")
    List<Prescription> findPrescriptionsByLbp(@Param("lbp") String lbp);

}
