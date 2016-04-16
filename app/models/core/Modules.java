package models.core;

import models.core.question_answers.ModuleQuestions;
import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "MODULES", schema = Constants.SCHEMA_NAME_CORE_MODULES)
public class Modules implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODULE_ID")
    private Long moduleId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CHAPTER_ID")
    private Chapters chapterId;

    @Column(name = "MODULE_NAME", length = 30)
    private String moduleName;

    @Column(name = "INDEXING", nullable = false, unique = true)
    private Integer indexing;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleIdQuestionId.moduleId")
    private Set<ModuleQuestions> moduleQuestions;
}
