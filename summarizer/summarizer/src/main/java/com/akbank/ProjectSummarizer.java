package com.akbank;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Developer;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

<<<<<<< HEAD
/*
    this project created to summarize project information.
    Custom maven plugin
 */
=======
>>>>>>> bb23a1d1842bd2468f7fd7e6508fa9dacb7505bc

@Mojo(name = "project-summarize", defaultPhase = LifecyclePhase.COMPILE)
public class ProjectSummarizer extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject mavenProjectproject;

    @Parameter(defaultValue = "${project.build.directory}")
    private File outputDirectory;

    public void execute() throws MojoExecutionException, MojoFailureException {


<<<<<<< HEAD
        String projectInfo=mavenProjectproject.getGroupId()+"-"+ mavenProjectproject.getArtifactId()+"-"+mavenProjectproject.getVersion();
=======
        String projectInfo=mavenProjectproject.getGroupId()+" "+ mavenProjectproject.getArtifactId()+" "+mavenProjectproject.getVersion();
>>>>>>> bb23a1d1842bd2468f7fd7e6508fa9dacb7505bc
        Properties properties = mavenProjectproject.getProperties();
        List<Developer> developers = mavenProjectproject.getDevelopers();
        List<Dependency> dependencies = mavenProjectproject.getDependencies();
        List<Plugin> buildPlugins = mavenProjectproject.getBuildPlugins();

        try {

<<<<<<< HEAD
        File outputFile = new File(outputDirectory,"project-summarize.txt");

=======
        File file=outputDirectory;

        if ( !file.exists() )
            file.mkdirs();

        File outputFile = new File( file, "project-summarize.txt" );
>>>>>>> bb23a1d1842bd2468f7fd7e6508fa9dacb7505bc
        FileWriter writer=new FileWriter(outputFile);
        writer.write("Project info: "+projectInfo+ "\n");

        // write developers info
<<<<<<< HEAD
        int index=1;
        writer.write("\n---Developers---\n");
=======
        int index=0;
        writer.write("---Developers---\n");
>>>>>>> bb23a1d1842bd2468f7fd7e6508fa9dacb7505bc
        for(Developer developer:developers)
            writer.write((index++) +"- Developer: "+developer.getName()+"\n");


        //write release info
<<<<<<< HEAD
        writer.write("\nRelease Date: " + properties.getProperty("release.date") + "\n");


        //write dependency info
        writer.write("\n---Dependencies---\n");
=======
        writer.write("Release Date: " + properties.getProperty("release.date") + "\n");


        //write dependency info
        writer.write("---Dependencies---\n");
>>>>>>> bb23a1d1842bd2468f7fd7e6508fa9dacb7505bc
        for(Dependency dependency : dependencies) {
            writer.write("Dependency: " + dependency.getGroupId() + "." + dependency.getArtifactId() + "\n");
        }

        //write plugins info
<<<<<<< HEAD
        writer.write("\n---Plugins---\n");
=======
        writer.write("---Plugins---\n");
>>>>>>> bb23a1d1842bd2468f7fd7e6508fa9dacb7505bc
        for(Plugin plugin : buildPlugins) {
            writer.write("Plugin: " + plugin.getArtifactId() + "\n");
        }

        writer.close();

        } catch (IOException e) {
            getLog().error("An error occurred while writing to the file");
            e.printStackTrace();
        }


    }
}
