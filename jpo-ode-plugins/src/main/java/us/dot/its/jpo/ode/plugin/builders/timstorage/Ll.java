package us.dot.its.jpo.ode.plugin.builders.timstorage;

import us.dot.its.jpo.ode.plugin.asn1.Asn1Object;

public class Ll extends Asn1Object
{
   private static final long serialVersionUID = 1L;
   private Nodes nodes;

    public Nodes getNodes ()
    {
        return nodes;
    }

    public void setNodes (Nodes nodes)
    {
        this.nodes = nodes;
    }

}
