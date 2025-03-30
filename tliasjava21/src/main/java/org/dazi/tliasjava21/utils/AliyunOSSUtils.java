package org.dazi.tliasjava21.utils;

import java.io.*;
import java.util.Random;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wei
 */
@Slf4j
@Component
public class AliyunOSSUtils {

  public void uploadOSS(MultipartFile file) throws com.aliyuncs.exceptions.ClientException {
    String endpoint = "oss-cn-shanghai.aliyuncs.com";
    String bucketName = "dazitemptest";
    String region = "oss-cn-shanghai";

    // 创建 OSSClient 实例
    EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
    OSS ossClient = OSSClientBuilder
        .create()
        .endpoint(endpoint)
        .credentialsProvider(credentialsProvider)
        .region(region)
        .build();

    try {

      // 上传文件
      String originalFilename = file.getOriginalFilename();
      String fileSuffix = FileUtils.getFileSuffix(originalFilename, true);
      String fileFullName = UUIDUtils.generateUUID() + fileSuffix;
      ossClient.putObject(bucketName, fileFullName, file.getInputStream());
      log.info("文件 " + fileFullName + " 上传成功。");

    } catch (OSSException oe) {
      log.error("Caught an OSSException, which means your request made it to OSS, " + "but was rejected with an error response for some reason.");
      log.error("Error Message:" + oe.getErrorMessage());
      log.error("Error Code:" + oe.getErrorCode());
      log.error("Request ID:" + oe.getRequestId());
      log.error("Host ID:" + oe.getHostId());
    } catch (ClientException | IOException ce) {
      log.error("Caught an ClientException, which means the client encountered " + "a serious internal problem while trying to communicate with OSS, " + "such as not being able to access the network.");
      log.error("Error Message:" + ce.getMessage());
    } finally {
      if (ossClient != null) {
        ossClient.shutdown();
      }
    }
  }

}
