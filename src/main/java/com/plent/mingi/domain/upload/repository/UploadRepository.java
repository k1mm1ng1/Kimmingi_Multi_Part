package com.plent.mingi.domain.upload.repository;

import com.plent.mingi.domain.upload.entity.Upload;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadRepository extends CrudRepository<Upload, Long> {
}
